package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "QuestionID")
	private int queId;

	@Column(name = "Question")
	private String que;

//	@OneToOne
//	@JoinColumn(name="a_id")
//	private Answer answers;

	// many to many
	@OneToMany(mappedBy = "question")
	List<Answer> answers;

	public Question() {
		super();

	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
