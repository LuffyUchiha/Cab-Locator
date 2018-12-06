public static class TokenizerMapper
 
extends Mapper<Object, Text, Text, IntWritable>{
 
java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
 
String[] days ={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"}; /*Converting date into 7 days*/
 
private Text basement = new Text();
 
Date date = null;
 
private int trips;
 
public void map(Object key, Text value, Context context
 
) throws IOException, InterruptedException {
 
String line = value.toString();
 
String[] splits = line.split(",");/* Split each line of the string into 4 different columns based on ‘,’*/
 
basement.set(splits[0]);
 
try {
 
date = format.parse(splits[1]); //Try to parse the string into date datatype
 
} catch (ParseException e) {
 
// TODO Auto-generated catch block
 
e.printStackTrace();
 
}
 
trips = new Integer(splits[3]);
 
String keys = basement.toString()+ " "+days[date.getDay()];
 
context.write(new Text(keys), new IntWritable(trips));
 
}
 
}
