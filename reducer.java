public static class IntSumReducer
 
extends Reducer<Text,IntWritable,Text,IntWritable> {
 
private IntWritable result = new IntWritable();
 
public void reduce(Text key, Iterable<IntWritable> values,
 
Context context
 
) throws IOException, InterruptedException {
 
int sum = 0;
 
for (IntWritable val : values) {
 
sum += val.get(); /* Calculating the total rides*/
 
}
 
result.set(sum);
 
context.write(key, result);
 
}
 
}
