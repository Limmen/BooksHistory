package Util;

public class booksDTO implements Comparable
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

    @Override
    public int compareTo(Object c) 
    {
        booksDTO b = (booksDTO) c;
         if(b.author.equalsIgnoreCase(this.author) && b.comment.equalsIgnoreCase(this.comment)
                && b.grade.equalsIgnoreCase(this.grade) && b.title.equalsIgnoreCase(this.title)
                && b.year.equalsIgnoreCase(this.year))
        {
            return 0;
        }
        else
            return -1;
    }
}
