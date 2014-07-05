package com.hyyy.spider;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.ansj.domain.Term;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.ToAnalysis;

public class Fenci {
	
	public static void main(String[] args) throws IOException {
	   
		Analysis udf = new ToAnalysis(new StringReader("西红柿炒鸡蛋怎么做"));
	    Term term = null ;
	    while((term=udf.next())!=null){
	       ArrayList results = new ArrayList<>() ;
	       String result = term.getName() ;
	       results.add(result) ;
	    	System.out.print(results);
	    }

	    }
}
