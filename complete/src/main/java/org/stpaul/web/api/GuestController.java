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
import org.stpaul.configuration.BaseController;
import org.stpaul.model.Guest;
import org.stpaul.service.GuestService;

import java.util.List;

/**
 * Created by tjc4h on 4/3/2017.
 */
@Api
@RestController
@RequestMapping("/api/guest")
public class GuestController extends BaseController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") Long id) {
        Guest guest = guestService.findById(id);
        if (guest == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(guest);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guest>> getGuests() {
        List<Guest> guests = guestService.findAll();
        return ResponseEntity.ok(guests);
    }
}

