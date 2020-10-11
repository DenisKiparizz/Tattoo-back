package com.tattoo.com.annotation;

import io.swagger.annotations.*;

import java.lang.annotation.*;

@Documented
@ApiOperation("Get Part Of Body")
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
        ),
        @ApiResponse(
                code = 404,
                message = "Part of Body not found"
        )
})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GetPartOfBodyDescription {
}
