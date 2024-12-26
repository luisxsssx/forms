package com.backend.forms.service;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.OptionModel;
import com.backend.forms.repository.OptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionService {

    @Autowired
    private OptionRepo optionRepo;
    private OptionModel optionModel;

    @Transactional
    public ApiResponse saveOption() {
        try {
            optionRepo.saveOptions(
                    this.optionModel.question_id,
                    this.optionModel.option_text
            );
            return new ApiResponse("Option saved correctly");
        } catch (Exception e) {
            throw new ExceptionMessage("Error saving the option" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public ApiResponse deleteOption() {
        try {
            optionRepo.deleteOption(optionModel.optionId);
            return new ApiResponse("Options deleted");
        } catch (Exception e) {
            throw new ExceptionMessage("Error deleting the option" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public ApiResponse updateOptions() {
        try {
            optionRepo.updateOptions(optionModel.question_id, optionModel.option_text);
            return new ApiResponse("Updated options");
        } catch (Exception e) {
            throw new ExceptionMessage("Failed to update data" + e.getMessage(), 1002);
        }
    }

}