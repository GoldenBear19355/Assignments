package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bo.LcsObject;
import com.example.demo.bo.LcsResponse;
import com.example.demo.service.LcsService;

/**
 * @author Sudhakar
 *
 */
@Service
public class LcsServiceImpl implements LcsService {

	@Override
	public LcsResponse findLcs(List<String> strings) {
		return lcsAlgo(strings);
	}

//	TODO : Optimize with Suffix Trie Algo
	private LcsResponse lcsAlgo(List<String> strings) {
		int n = strings.size();
		String s = strings.get(0);
		int len = s.length();
		List<LcsObject> resSet = new ArrayList<>();
		String res = "";

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String sub = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++) {
					if (!strings.get(k).contains(sub)) {
						break;
					}
				}
				if (k == n && res.length() < sub.length()) {
					res = sub;
					resSet.clear();
					resSet.add(new LcsObject(res));
				} else if (k == n && res.length() == sub.length()) {
					resSet.add(new LcsObject(sub));
				}
			}
		}

		Collections.sort(resSet);
		LcsResponse lcsResponse = new LcsResponse(resSet);

		return lcsResponse;
	}

}
