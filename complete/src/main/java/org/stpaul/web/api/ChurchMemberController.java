package org.stpaul.web.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stpaul.BaseController;
import org.stpaul.model.ChurchMember;
import org.stpaul.service.ChurchMemberService;

import java.util.List;

@Api
@RestController
@RequestMapping("/api/churchMember")
public class ChurchMemberController extends BaseController {

    @Autowired
    private ChurchMemberService churchMemberService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChurchMember> getChurchMemberById(@PathVariable("id") Long id) {
        ChurchMember churchMember = churchMemberService.findById(id);
        if (churchMember == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(churchMember);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChurchMember>> getChurchMembers() {
        List<ChurchMember> churchMembers = churchMemberService.findAll();
        return ResponseEntity.ok(churchMembers);
    }
}
