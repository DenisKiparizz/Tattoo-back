package com.tattoo.com.annotation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.lang.annotation.*;

@Documented
@ApiOperation("Welcome to this API")
@ApiResponses(value = {
        @ApiResponse(
                code = 200,
                message = "Successful"
        ),
        @ApiResponse(
                code = 400,
                message = "Bad request"
        ),
        @ApiResponse(
                code = 401,
                message = "Unauthorized"
        ),
        @ApiResponse(
                code = 500,
                message = "Internal server error"
        )
})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SwaggerAnnotation {
}
