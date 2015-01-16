package Util;

public class booksDTO 
{
	private String title;
	private String author;
	private String year;
	private String comment;
	private String grade;
	public booksDTO(String title, String author, String year, String comment, String grade)
	{
		this.title=title;
		this.author = author;
		this.year = year;
		this.comment = comment;
		this.grade = grade;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getYear()
	{
		return this.year;
	}
	public String getComment()
	{
		return this.comment;
	}
	public String getGrade()
	{
		return this.grade;
	}
}
