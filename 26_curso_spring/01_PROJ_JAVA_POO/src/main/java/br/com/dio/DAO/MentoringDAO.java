package br.com.dio.DAO;


import br.com.dio.Model.Mentoring;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MentoringDAO {
    private List<Mentoring> mentorings = new ArrayList<>();

    public List<Mentoring> insertMentoring(Mentoring mentoring) {
        this.mentorings.add(mentoring);
        return mentorings;
    }

}
