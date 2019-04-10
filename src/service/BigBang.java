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

public class BigBang {

    @Test
    public void addStudent()
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
    public void addAssignment()
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
        for (Tema assignment : service.findAllTeme())
        {
            count += 1;
        }
        service.saveTema(Integer.toString(count + 100), "Test descr", 4, 2);
        for (Tema assignment : service.findAllTeme())
        {
            countafter += 1;
        }
        assert(count + 1 == countafter);
    }

    @Test
    public void addGrade()
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
        for (Nota nota : service.findAllNote())
        {
            count += 1;
        }
        service.saveStudent(Integer.toString(count+2000), "Calin", 500);
        service.saveTema(Integer.toString(count + 2000), "Test descr", 4, 2);
        service.saveNota(Integer.toString(count + 2000), Integer.toString(count + 2000), 5, 4, "Un pisat");

        for (Nota nota : service.findAllNote())
        {
            countafter += 1;
        }
        assert(count + 1 == countafter);
    }

    @Test
    public void addAll()
    {
        addGrade();
        addStudent();
        addAssignment();
        assert(true);
    }

}
