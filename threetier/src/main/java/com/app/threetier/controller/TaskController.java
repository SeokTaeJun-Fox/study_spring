package com.app.threetier.controller;

import com.app.threetier.service.TaskService;
import com.app.threetier.vo.TaskVO;
import jakarta.jws.WebParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/tasks/*")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/register")
    public void goToRegister(TaskVO taskVO) {;}

    @PostMapping("/result-ok")
    public RedirectView resultOK(TaskVO taskVO, RedirectAttributes redirectAttributes) {
        Float average = taskService.getAverage(taskVO);
        log.info("average : {}", average);
        log.info("taskVO : {}", taskVO);

        redirectAttributes.addAttribute("average", average);
        redirectAttributes.addAttribute("total", (int)(average*3));
        redirectAttributes.addFlashAttribute("taskVO", taskVO);

        return new RedirectView("/tasks/result");
    }

    @GetMapping("/result")
    public void goToResult(TaskVO taskVO, Float average,
                           Integer total, Model model) {
        log.info("vo : {}", model.getAttribute("taskVO"));
        model.addAttribute("average", average);
        model.addAttribute("total", total);
    }
}
