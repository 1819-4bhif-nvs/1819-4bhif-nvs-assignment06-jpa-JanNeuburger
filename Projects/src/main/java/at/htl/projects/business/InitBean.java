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
import java.util.List;

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
        List<Object> students = List.of(wimmer,riedl,kress,pichler,schuster,weinheber,bauer,winkler);

        Teacher haspel = new Teacher("Valentin", "Haspel","Prof");
        Teacher schwarz = new Teacher("Levi", "Schwarz","Dr");
        Teacher waltz = new Teacher("Emil", "Waltz","Mag");
        Teacher egger = new Teacher("Mia", "Egger","Dipl Ing");
        Teacher haas = new Teacher("Helene", "Haas","PhD");
        List<Object> teachers = List.of(haspel,schwarz,waltz,egger,haas);

        Project mig = new Project("MakeItGo","NAO-Soccer Project");
        Project ear = new Project("Einnahmen-Ausgaben-Rechnung","Programm für eBanking");
        Project voting = new Project("Music Voting", "Programm zur Musikabstimmung bei Parties");
        Project houseAutomation = new Project("Hausautomation","Visualisierung für SmartHome");
        Project leonie = new Project("Leonie","Avatar der HTL-Leonding");
        List<Object> projects = List.of(mig,ear,voting,houseAutomation,leonie);

        Meeting m1 = new Meeting(LocalDateTime.now(),"Sprint Review Oktober");
        Meeting m2 = new Meeting(LocalDateTime.now().plusMonths(1), "Sprint Review November");
        Meeting e1 = new Meeting(LocalDateTime.now().plusDays(20), "Elba Testsitzng");
        Meeting e2 = new Meeting(LocalDateTime.now().plusWeeks(6), "George Testsitzung");
        Meeting v1 = new Meeting(LocalDateTime.now().plusDays(3), "Spotify Besprechung");
        Meeting h1 = new Meeting(LocalDateTime.now(), "Sensorentest");
        Meeting l1 = new Meeting(LocalDateTime.now().plusMonths(2), "Tag der offenen Tür Generalprobe");
        List<Object> meetings = List.of(m1,m2,e1,e2,v1,h1,l1);

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

        wimmer.addProject(mig);
        weinheber.addProject(mig);
        riedl.addProject(ear);
        kress.addProject(voting);
        pichler.addProject(houseAutomation);
        bauer.addProject(houseAutomation);
        schuster.addProject(leonie);
        winkler.addProject(leonie);

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

        persistList(projects);
        persistList(students);
        persistList(teachers);
        persistList(meetings);


        System.out.println("Finished");
    }

    private void persistList(List<Object> list){
        for (Object item: list) {
            em.persist(item);
        }
    }
}
