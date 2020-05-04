package com.vamshi.springboot.mytodolist.controller;

import com.vamshi.springboot.mytodolist.entity.TodoList;
import com.vamshi.springboot.mytodolist.service.TodoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mytodolist")
public class TodoListController {

    private TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/list")
    public String showAllLists(Model theModel){

        List<TodoList> todoLists = todoListService.findAll();
        TodoList todoList = new TodoList();
        theModel.addAttribute("todoLists",todoLists);
        theModel.addAttribute("theTodoList",todoList);
        return "todolists";
    }

    @PostMapping("/save")
    public String saveTodoList(@ModelAttribute("theTodoList") TodoList theTodoList){
        todoListService.save(theTodoList);
        return "redirect:/mytodolist/list";
    }
    @GetMapping("/delete/{theId}")
    public String saveTodoList(@PathVariable int theId){
        todoListService.deleteById(theId);
        return "redirect:/mytodolist/list";
    }

}
