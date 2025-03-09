import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizService } from '../../../services/quiz.service';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { ThemePalette } from '@angular/material/core';
import { CategoryService } from '../../../services/category.service';
import Swal from 'sweetalert2';
import { MatDatetimepickerModule } from "@mat-datetimepicker/core";
import { MatNativeDatetimeModule } from '@mat-datetimepicker/core';

@Component({
  selector: 'app-update-quiz',
  standalone: true,
  imports: [
    MatCardModule, MatListModule, MatIconModule, MatButtonModule, RouterLink,
    CommonModule, MatFormFieldModule, FormsModule, MatInputModule, MatSlideToggleModule,
    MatSelectModule, MatDatetimepickerModule, MatNativeDatetimeModule
  ],
  templateUrl: './update-quiz.component.html',
  styleUrl: './update-quiz.component.css'
})
export class UpdateQuizComponent implements OnInit {

  constructor(private route: ActivatedRoute, private quizService: QuizService,
    private categoryService: CategoryService, private router: Router) { }

  qid = 0;
  quiz: any = {}; // Ensure quiz is initialized
  categories: any = [];
  color: ThemePalette = 'primary';
  checked = false;
  disabled = false;
  scheduledTime: Date | undefined;

  ngOnInit(): void {
    this.qid = this.route.snapshot.params['qid'];

    // Fetch Quiz Details
    this.quizService.getQuiz(this.qid).subscribe(
      (data: any) => {
        console.log("API Response:", data); // Debugging API response
        this.quiz = data;

        // Ensure category exists to avoid undefined errors
        if (!this.quiz.category) {
          console.warn("Quiz category is missing from API response!");
          this.quiz.category = { cid: null };
        }

        // Handle scheduled time
        if (this.quiz.scheduledDate && this.quiz.scheduledHour != null && this.quiz.scheduledMinute != null) {
          this.scheduledTime = new Date(this.quiz.scheduledDate);
          this.scheduledTime.setHours(this.quiz.scheduledHour);
          this.scheduledTime.setMinutes(this.quiz.scheduledMinute);
        }
      },
      (error) => {
        console.error("Error fetching quiz:", error);
      }
    );

    // Fetch Categories
    this.categoryService.categories().subscribe(
      (data: any) => {
        this.categories = data;
      },
      (error) => {
        alert("Error occurred while loading categories");
      }
    );
  }

  public updateQuiz() {
    this.quizService.updateQuiz(this.qid, this.quiz).subscribe(
      (data: any) => {
        Swal.fire("Updated", "Quiz updated", "success").then(() => {
          this.router.navigate(["/adminDashboard/quiz"]);
        });
      },
      (error) => {
        Swal.fire("Error", "Error Occurred!!", "error");
        console.error("Update error:", error);
      }
    );

    // Handle scheduled time logic
    if (this.scheduledTime) {
      const now = new Date();
      const scheduledDate = this.scheduledTime;
      const timeDifference = scheduledDate.getTime() - now.getTime();

      if (timeDifference > 0) {
        setTimeout(() => {
          console.log("Quiz scheduled time reached. Updating quiz...");
        }, timeDifference);
      } else {
        console.warn("Scheduled time has already passed!");
      }
    }
  }
}
