package Yotoqxona.controller;

import Yotoqxona.entity.Student;
import Yotoqxona.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Page<Student> getAll(Pageable pageable){
        return studentService.getAll(pageable);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.deleteById(id);
    }
}
