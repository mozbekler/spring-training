package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String mentorPage(Model model){

        List<Mentor> mentorList = new ArrayList<>();

        Mentor mentor1 = new Mentor("Mike","Smith",45, Gender.MALE);
        Mentor mentor2 = new Mentor("Tom","Hanks",65, Gender.MALE);
        Mentor mentor3 = new Mentor("Ammy","Bryan",25, Gender.FEMALE);

        mentorList.addAll(Arrays.asList(mentor1,mentor2,mentor3));

        model.addAttribute("mentors",mentorList);



        return "mentor/mentor-list";
    }
}
