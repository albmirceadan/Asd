package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

public class ServiceTest
{
    @Test
    public void addStudentTest0()
    {
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        service.saveStudent(Integer.toString(count+1000), "Calin", 500);
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 == countafter);
    }

    @Test
    public void addStudentTest1()
    {
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        service.saveStudent(Integer.toString(count + 10000), "Calin", 500);
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 == countafter);
    }

    @Test
    public void addStudentTest2()
    {
        String group = "abc";
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        try
        {
            service.saveStudent("abc", "Calin", Integer.parseInt(group));
        }
        catch (NumberFormatException exc)
        {

        }
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 != countafter);
    }
    @Test
    public void addStudentTest3()
    {
        String group = "abc";
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        try
        {
            service.saveStudent("abc", "Calin", Integer.parseInt(group));
        }
        catch (NumberFormatException exc)
        {

        }
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 != countafter);
    }

    @Test
    public void addStudentTestDelete()
    {
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        service.saveStudent(Integer.toString(count + 100), "s", 120);
        System.out.println(count);
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 == countafter);

        service.deleteStudent(Integer.toString(count + 100));
        countafter = 0;
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count == countafter);
    }
}
