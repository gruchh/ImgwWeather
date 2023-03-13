package com.gruchh.weather.App.Service;

import com.gruchh.weather.App.Repository.Entity.MeasurementUpdate;
import com.gruchh.weather.App.Repository.MeasurementUpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MeasureUpdateService {

    private final MeasurementUpdateRepository measurementUpdateRepository;

    public Boolean ifTodaysMeasureIsUpdated() {
        return measurementUpdateRepository.findByDate(LocalDate.now()).isEmpty();
    }

    public MeasurementUpdate saveTodaysUpdateInformation() {
        return measurementUpdateRepository.save(new MeasurementUpdate(LocalDate.now()));
    }
}
