package com.calculator.repository;

import org.springframework.stereotype.Repository;

import com.calculator.domain.Node;

@Repository
public class NodeReopositoryImpl extends BaseRepositoryImpl<Node> implements NodeRepository{

	public NodeReopositoryImpl() {
		super(Node.class);	
	}

}
