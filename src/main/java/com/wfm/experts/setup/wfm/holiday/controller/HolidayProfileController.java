package com.wfm.experts.setup.wfm.holiday.controller;

import com.wfm.experts.setup.wfm.holiday.dto.HolidayProfileDTO;
import com.wfm.experts.setup.wfm.holiday.service.HolidayProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/setup/wfm/holiday-profiles")
@RequiredArgsConstructor
public class HolidayProfileController {

    private final HolidayProfileService holidayProfileService;

    @PostMapping
    public ResponseEntity<HolidayProfileDTO> createProfile(@RequestBody HolidayProfileDTO dto) {
        HolidayProfileDTO created = holidayProfileService.createProfile(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayProfileDTO> updateProfile(
            @PathVariable Long id,
            @RequestBody HolidayProfileDTO dto
    ) {
        HolidayProfileDTO updated = holidayProfileService.updateProfile(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayProfileDTO> getProfile(@PathVariable Long id) {
        HolidayProfileDTO profile = holidayProfileService.getProfile(id);
        return ResponseEntity.ok(profile);
    }

    @GetMapping
    public ResponseEntity<List<HolidayProfileDTO>> getAllProfiles() {
        List<HolidayProfileDTO> profiles = holidayProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        holidayProfileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
