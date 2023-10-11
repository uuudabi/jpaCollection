package org.jpa.jpacollection;

import org.jpa.jpacollection.entity.Member;
import org.jpa.jpacollection.entity.Student;
import org.jpa.jpacollection.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
class JpaCollectionApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
    }

    @Transactional
    @Test
    public void testStudent(){
        Student student = new Student("Pilseong","Heo","heops78@gmial.com");
        List<String> courses = student.getCourses();

        courses.add("Math");
        courses.add("Science");
        courses.add("Economics");
        courses.add("Language");
        courses.add("Language");
        em.persist(student);

        TypedQuery<Student> query = em.createQuery("SELECT m FROM Student m", Student.class);

        List<Student> resultList = query.getResultList();
        for(Student member : resultList){
            System.out.println("member = "+member);
        }

        Student st1 = em.find(Student.class,student.getId());
        for(String cours : st1.getCourses()){
            System.out.println(cours);
        }
    }

    @Test
    @Transactional
    @Commit
    public void testMember(){
        Team team = Team.builder().teamName("KFC").build();
        em.persist(team);
        Member member = Member.builder().name("박지성").team(team).build();
        em.persist(member);
        member = Member.builder().name("손흥민").team(team).build();
        em.persist(member);
        member = Member.builder().name("차범근").team(team).build();
        em.persist(member);

        em.flush();
        em.clear();


        member = em.find(Member.class, 1L);
        System.out.println("-------------------->"+ member);
        System.out.println(member.getTeam());

//        em.flush();
//        em.clear();
//
//        Team team1 = em.find(Team.class, 1L);
//        System.out.println(team1);
//        for (Member member1 : team1.getMemberList()){
//            System.out.println(member1);
//        }
    }

}
