package net.evercodig.helloblog.controller;

import net.evercodig.helloblog.pojo.Writing;
import net.evercodig.helloblog.pojo.WritingVO;
import net.evercodig.helloblog.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writings")
public class WritingController {

    @Autowired
    WritingService writingService;

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public Writing findWriting(@PathVariable("id") Integer id) {
        Writing writing = writingService.selectWritingById(id);
        return writing;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Writing> findWrintingByAuthorAndHeading(@RequestParam String heading, @RequestParam String author) {
        List<Writing> writings = writingService.selectWritingByAuthorAndHeading(heading, author);
        return writings;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertWriting(@RequestBody WritingVO writingVO) {
        writingService.insertWriting(writingVO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateWriting(@RequestBody WritingVO writingVO, @PathVariable Integer id) {
        writingService.updateWriting(writingVO, id);
    }
}
