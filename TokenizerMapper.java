package tn.isima.exercice;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
       public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
              String[] tokens = value.toString().split(",");
              String cle = tokens[0].substring(0,1);
              int valeur = Integer.parseInt(tokens[1]);
              context.write(new Text(cle), new IntWritable(valeur));
       }
}
