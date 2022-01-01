package tn.isima.twetter;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class nbrReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	ArrayList<Integer> List = new ArrayList<Integer>();
public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
  double sum = 0;
        for (DoubleWritable val : values) {
            System.out.println("value: "+val.get());
            sum += val.get();
        }
        System.out.println("--> Sum = "+sum);
        result.set(sum);
        context.write(key, result);
    }
}
