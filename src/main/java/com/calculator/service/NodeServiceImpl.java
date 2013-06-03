package com.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calculator.domain.Node;
import com.calculator.repository.NodeRepository;

@Service
@Transactional
public class NodeServiceImpl implements  NodeService{
	@Autowired
	private NodeRepository nodeRepository;

	public NodeRepository getNodeRepository() {
		return nodeRepository;
	}

	public void setNodeRepository(NodeRepository nodeRepository) {
		this.nodeRepository = nodeRepository;
	}

	@Override
	public List<Node> getAllNodes() {
		return nodeRepository.getAll();
	}
	
	
}
