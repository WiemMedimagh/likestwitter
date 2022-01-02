package tn.isima.twetter;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public static class nbrReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
       public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException,InterruptedException {
              int sum = 0;
              for (IntWritable val : values) {
                   sum += val.get();
              }
       context.write(key, new IntWritable(sum));
       }
}

