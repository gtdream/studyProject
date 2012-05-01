package com.narratage.blog.project.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.narratage.blog.project.service.ProjectFileService;
import com.narratage.util.CommonUtils;

@Controller
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Resource(name="projectFileService")
	private ProjectFileService projectFileService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/treeView", method = RequestMethod.GET)
	public String treeView(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("FileTree");
		String projectPath = request.getParameter("project");
		projectPath="c:\\temp";
		String tree = projectFileService.getTree(projectPath);
		CommonUtils.ajaxResponse(request, response, tree);
		return null;
	}
	
	@RequestMapping(value = "/contentsView", method = RequestMethod.POST)
	public String contentsView(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		logger.info("Contents");
		String projectName = request.getParameter("projectName");
		String fileName = request.getParameter("fileName");
		projectName="c:\\temp";
		String source = projectFileService.getSourceContent(projectName,fileName);
		System.out.println(source);
		CommonUtils.ajaxResponse(request, response, source);
		return null;
	}

}
