package com.serverless.dao;

import java.io.IOException;
import java.util.List;

import com.serverless.domain.Mutant;

public interface MutantDao {

	public void save(Mutant mutant) throws IOException;
	public List<Mutant> list() throws IOException; 
}
