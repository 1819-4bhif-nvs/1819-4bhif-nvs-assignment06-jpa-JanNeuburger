package at.htl.projects.business;

import at.htl.projects.model.Meeting;
import at.htl.projects.model.Project;
import at.htl.projects.model.Student;
import at.htl.projects.model.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Startup
@Singleton
public class InitBean {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        System.out.println("Löding...");
        Student wimmer = new Student("Markus", "Wimmer","if1");
        Student riedl = new Student("Michael", "Riedl", "if2");
        Student kress = new Student("Simon", "Kress","if3");
        Student pichler = new Student("Christian", "Pichler","if4");
        Student schuster = new Student("Noah", "Schuster","if5");
        Student weinheber = new Student("Marlene", "Weinheber","if6");
        Student bauer = new Student("Celine", "Bauer","if7");
        Student winkler = new Student("Sophie", "Winkler","if8");

        Teacher haspel = new Teacher("Valentin", "Haspel","Prof");
        Teacher schwarz = new Teacher("Levi", "Schwarz","Dr");
        Teacher waltz = new Teacher("Emil", "Waltz","Mag");
        Teacher egger = new Teacher("Mia", "Egger","Dipl Ing");
        Teacher haas = new Teacher("Helene", "Haas","PhD");

        em.persist(wimmer);
        em.persist(riedl);
        em.persist(kress);
        em.persist(pichler);
        em.persist(schuster);
        em.persist(weinheber);
        em.persist(bauer);
        em.persist(winkler);
        em.persist(haspel);
        em.persist(schwarz);
        em.persist(waltz);
        em.persist(egger);
        em.persist(haas);

        Project mig = new Project("MakeItGo","NAO-Soccer Project");
        Project ear = new Project("Einnahmen-Ausgaben-Rechnung","Programm für eBanking");
        Project voting = new Project("Music Voting", "Programm zur Musikabstimmung bei Festen");
        Project houseAutomation = new Project("Hausautomation","Visualisierung für SmartHome");
        Project leonie = new Project("Leonie","Avatar der HTL-Leonding");

        Meeting m1 = new Meeting(LocalDateTime.now(),"Sprint Review Oktober");
        Meeting m2 = new Meeting(LocalDateTime.now().plusMonths(1), "Sprint Review November");
        Meeting e1 = new Meeting(LocalDateTime.now().plusDays(20), "Elba Testsitzng");
        Meeting e2 = new Meeting(LocalDateTime.now().plusWeeks(6), "George Testsitzung");
        Meeting v1 = new Meeting(LocalDateTime.now().plusDays(3), "Spotify Besprechung");
        Meeting h1 = new Meeting(LocalDateTime.now(), "Sensorentest");
        Meeting l1 = new Meeting(LocalDateTime.now().plusMonths(2), "Tag der offenen Tür Generalprobe");

//        wimmer.getMeetings().add(m1);
//        m1.getAttendants().add(wimmer);
//        haspel.getMeetings().add(m1);
//        m1.getAttendants().add(haspel);
//        waltz.getMeetings().add(m1);
//        m1.getAttendants().add(waltz);
//        weinheber.getMeetings().add(m1);
//        m1.getAttendants().add(weinheber);
//        wimmer.getMeetings().add(m2);
//        m2.getAttendants().add(wimmer);
//        haspel.getMeetings().add(m2);
//        m2.getAttendants().add(haspel);
//        weinheber.getMeetings().add(m2);
//        m2.getAttendants().add(weinheber);
//        schwarz.getMeetings().add(e1);
//        e1.getAttendants().add(schwarz);
//        riedl.getMeetings().add(e1);
//        e1.getAttendants().add(riedl);
//        riedl.getMeetings().add(e2);
//        e2.getAttendants().add(riedl);
//        schwarz.getMeetings().add(e2);
//        e2.getAttendants().add(schwarz);
//        waltz.getMeetings().add(v1);
//        v1.getAttendants().add(waltz);
//        kress.getMeetings().add(v1);
//        v1.getAttendants().add(kress);
//        egger.getMeetings().add(h1);
//        h1.getAttendants().add(egger);
//        bauer.getMeetings().add(h1);
//        h1.getAttendants().add(bauer);
//        haas.getMeetings().add(l1);
//        l1.getAttendants().add(haas);
//        schuster.getMeetings().add(l1);
//        l1.getAttendants().add(schuster);
//        winkler.getMeetings().add(l1);
//        l1.getAttendants().add(winkler);

        mig.getMembers().add(wimmer);
        mig.getMembers().add(weinheber);
        ear.getMembers().add(riedl);
        voting.getMembers().add(kress);
        houseAutomation.getMembers().add(pichler);
        houseAutomation.getMembers().add(bauer);
        leonie.getMembers().add(schuster);
        leonie.getMembers().add(winkler);

        mig.setSupervisor(haspel);
        ear.setSupervisor(schwarz);
        voting.setSupervisor(waltz);
        houseAutomation.setSupervisor(egger);
        leonie.setSupervisor(haas);

        mig.getMeetings().add(m1);
        mig.getMeetings().add(m2);
        ear.getMeetings().add(e1);
        ear.getMeetings().add(e2);
        voting.getMeetings().add(v1);
        houseAutomation.getMeetings().add(h1);
        leonie.getMeetings().add(l1);

        em.persist(m1);
        em.persist(m2);
        em.persist(e1);
        em.persist(e2);
        em.persist(v1);
        em.persist(h1);
        em.persist(l1);

        em.persist(mig);
        em.persist(ear);
        em.persist(voting);
        em.persist(houseAutomation);
        em.persist(leonie);

        System.out.println("Finished");
    }
}
