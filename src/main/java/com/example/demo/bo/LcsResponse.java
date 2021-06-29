package com.example.demo.bo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sudhakar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LcsResponse {
	
	private List<LcsObject> lcs;

}
