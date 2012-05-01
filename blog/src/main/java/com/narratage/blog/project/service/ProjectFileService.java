package com.narratage.blog.project.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.narratage.util.FileUtils;
import com.narratage.util.StringUtils;
import com.narratage.util.compare.ProjectFolderFirst;

@Service
public class ProjectFileService {

	public String getTree(String path) {
	
		File dir = new File(path);
		if (dir.exists() == false) {
			System.out.println("경로가 존재 하지 않습니다.");
			return null;
		}
		String s = dir.getPath();
		StringBuffer sb = new StringBuffer();

		int flag = 0;
		
		findProjectContentList(s, sb, dir, path);
		
		return sb.toString();
	}
	
	
	public String getSourceContent(String projectName,String fileName) throws IOException{
		StringBuffer sb = new StringBuffer();
		
		System.out.println(fileName);
		FileUtils.getFileContents(sb, projectName, fileName);
		
		return sb.toString();
		
	}
	
	public static void findProjectContentList(String s, StringBuffer sb, File dir,String project) {

		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			Arrays.sort(children,new ProjectFolderFirst());
			sb.append("<ul>");
			sb.append("<li>");
			sb.append("<a href=\"#\">");
			sb.append(dir.getName());
			sb.append("</a>");
			
			for (File f : children) {
			
				findProjectContentList(s, sb, f, project);
			}
			
		} else {
			sb.append("<ul>");
			sb.append("<li>");
			sb.append("<a href=\"#\" ");
			sb.append(" onclick=\"javascript:showContent('");
			sb.append(project);
			sb.append("','");
			sb.append((StringUtils.replace(dir.getPath().substring(s.length()), "\\", "/")));
			sb.append("');\" >");
			sb.append(dir.getName());
			sb.append("</a>");
			
		}
		sb.append("</li>");
		sb.append("</ul>");
	}
}