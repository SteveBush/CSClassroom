﻿using System;

namespace CSC.CSClassroom.WebApp.ViewModels.Question
{
	/// <summary>
	/// A type of question.
	/// </summary>
	public class QuestionType
	{
		/// <summary>
		/// The type of question referred to by this object.
		/// </summary>
		public Type Type { get; private set; }

		/// <summary>
		/// The display name of the type of question.
		/// </summary>
		public string DisplayName { get; private set; }

		/// <summary>
		/// The description of the type of question.
		/// </summary>
		public string Description { get; private set; }

		/// <summary>
		/// Constructor.
		/// </summary>
		public QuestionType(Type type)
		{
			Type = type;

			var question = (Model.Assignments.Question)Activator.CreateInstance(type);
			DisplayName = question.QuestionTypeDisplay;
			Description = question.QuestionTypeDescription;
		}
	}
}
