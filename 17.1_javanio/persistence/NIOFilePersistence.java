package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class NIOFilePersistence implements FilePersistence {
    private final String currentDir = System.getProperty("user.dir");
    private final String storeDir = "/managedFiles/IO/";
    private final String fileName;
    
    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storeDir);
        if(!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");
        clearFile();
    }

    @Override
    public String write(final String data){
        try( //não é possível trabalhar com qualquer variável dentro desse bloco, apenas autoclose
            var fileWriter = new RandomAccessFile(new File(currentDir+storeDir+fileName), "rw"); //mode rw read write
        ){
            fileWriter.seek(fileWriter.length()); //define a posição em que vai escrever
            fileWriter.writeBytes(data);
            fileWriter.writeBytes(System.lineSeparator());
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(final String sentence){
        var contentList = toListString();
        if(contentList.stream().noneMatch(c -> c.contains(sentence))){
            return false;
        }
        clearFile();
        contentList.stream().filter(c -> !c.contains(sentence)).forEach(this::write);
        return true;
    }


    @Override
    public String replace(final String oldContent, final String newContent){
        List<String> contentList = toListString();

        if(contentList.stream().noneMatch(c -> c.contains(oldContent))){
            return "";
        }

        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);

        return newContent;
    }

    private List<String> toListString() {
        var content = findAll();
        List<String> contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        return contentList;
    }

    @Override
    public String findAll(){
        var content = new StringBuilder();
        try(
            var fileWriter = new RandomAccessFile(new File(currentDir+storeDir+fileName), "rw");
            var channel = fileWriter.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader!=-1) {
                buffer.flip();
                while(buffer.hasRemaining()){
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(final String sentence){
        var content = new StringBuilder();
        try(
            var fileWriter = new RandomAccessFile(new File(currentDir+storeDir+fileName), "r");
            var channel = fileWriter.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader!=-1) {
                buffer.flip();
                while(buffer.hasRemaining()){
                    while(!content.toString().endsWith(System.lineSeparator())){
                        content.append((char) buffer.get());
                    }
                    if(content.toString().contains(sentence)){
                        return content.toString();
                    }else{
                        content.setLength(0);
                    }
                    if(!content.isEmpty()){
                        break;
                    }
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }

    private void clearFile(){
        try(OutputStream outputStream = new FileOutputStream(new File(currentDir + storeDir + fileName))){
            //outputStream.close(); -> o java ja faz isso por isso não é mais necessário
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void createFile(){

    }
}
