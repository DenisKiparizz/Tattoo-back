package com.tattoo.com.dto.request;

import com.tattoo.com.dto.StyleInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StyleRequest implements StyleInterface {
    private String style;
}
