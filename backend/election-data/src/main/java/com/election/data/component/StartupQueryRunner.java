package com.election.data.component;

import com.election.data.dao.ElectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class StartupQueryRunner implements CommandLineRunner {

    @Autowired
    ElectionDao electionDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("App has started!");
        System.out.println(System.getProperty("user.dir"));
        try (Scanner scanner = new Scanner(new File("/csv-data/ls-data.csv"))) {
            while (scanner.hasNextLine()) {
                getRecordFromLine(scanner.nextLine());
            }
        }
    }

    private void getRecordFromLine(String data) {
        Scanner scan = new Scanner(data);
        scan.useDelimiter(",");
        String state = scan.next();
        String year = scan.next();
        String constno = scan.next();
        String city = scan.next();
        String category = scan.next();
        String candidatename = scan.next();
        if(!electionDao.checkIfCityExists(city, state)) {
            electionDao.insertCity(city, state);
        }

        if(!electionDao.checkIfCandidateExists(candidatename)) {
            electionDao.insertCandidate(candidatename);
        }
    }
}
