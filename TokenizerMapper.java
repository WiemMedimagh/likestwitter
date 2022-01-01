package tn.isima.exercice;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public  class TokenizerMapper
extends Mapper<LongWritable, Text, Text, IntWritable>{


private IntWritable nbrlike= new IntWritable();

private Text Key=new Text();
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    String line = value.toString();

	String[] data=line.split("\t");
	
	Key.set(data[9]);
	intnumber_of_likes= Integer.parseInt(data[1]);
	nbrlike.set(number_of_likes);
	
		
	System.out.println("author="+Key+"number_of_likes="+ nbrlike);
	context.write(Key,nbrlike);
		
		

}
}
