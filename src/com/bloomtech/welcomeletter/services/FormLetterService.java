package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    // With help from BloomTech Learner Bot
    private static final String TEMPLATE_PATH = "LetterTemplate";

    public void generateWelcomeLetter(Employee employee) throws IOException {
        // Get template text from resources
        String template = fileManager.getTextFromFile(TEMPLATE_PATH);

        // Replace []ed text with correct info
        String letter = replacePlaceholders(template, employee);

        // Write finalized String to file
        fileManager.writeTextToFile("Welcome" + employee.getFirstname() + employee.getLastname(), letter);
    }

    private String replacePlaceholders(String template, Employee employee) {
        return template.replace("[fullname]", employee.getFirstname() + " " + employee.getLastname())
                //.replace("[last_name]", employee.getLastname())
                //.replace("[phone_number]", employee.getPhonenumber())
                //.replace("[email]", employee.getEmail())
                .replace("[startingsalary]", Integer.toString(employee.getSalary()))
                .replace("[startdate]", employee.getStartdate().toString())
                //.replace("[role]", employee.getRole().toString())
                .replace("[company starttime]", employee.getCompany().getCompanyname())
                .replace("[company name]", employee.getCompany().getCompanyname());
                //.replace("[id]", employee.getId().toString);

    }
}
