package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidGenre;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateBudget;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateDuration;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateGross;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateLength;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateName;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateRating;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateScore;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateTitle;
import com.spartaglobal.moviesapi.controller.ValidationInterfaces.ValidateYear;

public interface FilmValidation extends ValidateBudget, ValidateDuration, ValidateGross,
    ValidateLength, ValidateName, ValidateRating, ValidateScore, ValidateTitle, ValidateYear,
    ValidGenre {

}
