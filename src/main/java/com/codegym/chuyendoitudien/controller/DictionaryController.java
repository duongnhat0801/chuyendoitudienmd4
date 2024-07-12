package com.codegym.chuyendoitudien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("apple", "quả táo");
        dictionary.put("banana", "quả chuối");
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ");
        }
        return "result";
    }

}
