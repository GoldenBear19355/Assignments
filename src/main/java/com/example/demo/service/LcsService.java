package com.example.demo.service;

import java.util.List;

import com.example.demo.bo.LcsResponse;

/**
 * @author Sudhakar
 *
 */
@FunctionalInterface
public interface LcsService {

	LcsResponse findLcs(List<String> strings);

}
