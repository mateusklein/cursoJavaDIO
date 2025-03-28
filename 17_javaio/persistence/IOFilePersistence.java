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
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class IOFilePersistence implements FilePersistence {
    private final String currentDir = System.getProperty("user.dir");
    private final String storeDir = "/managedFiles/IO/";
    private final String fileName;
    
    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storeDir);
        if(!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");
        clearFile();
    }

    @Override
    public String write(final String data){
        try( //não é possível trabalhar com qualquer variável dentro desse bloco, apenas autoclose
            var fileWriter = new FileWriter(currentDir+storeDir+fileName, true);
            var bufferedWrite = new BufferedWriter(fileWriter);            
            var printWriter = new PrintWriter(bufferedWrite)    
        ){
            printWriter.println(data);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(final String sentence){
        List<String> contentList = toListString();
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
            var reader = new BufferedReader(new FileReader(currentDir+storeDir+fileName));
        ){
            String line;
            do{
                line = reader.readLine();
                if(line!=null) content.append(line).append(System.lineSeparator());
            }while(line != null);
        }catch(IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(final String sentence){
        String found = null;
        try(
            var reader = new BufferedReader(new FileReader(currentDir + storeDir + fileName))
        ){
            String line;
            do{
                line = reader.readLine();
                if(line!=null && (line.contains(sentence))){
                    found = line;
                    break;
                } 
            }while(line != null);
        }catch(IOException e){
            e.printStackTrace();
        }
        return found;
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
