import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../login.service';
import { User } from '../models/models/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  userObject = new User();
  image?: File
  wantToUpdate: boolean = false;
  currentUser?: User;
  isFileValid?: boolean;
  profilePicture?: string;



  addressForm = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(4),Validators.pattern('[a-zA-Z ]*')]],
    email: [null, [Validators.required, Validators.pattern(/^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i)]],
    password: [null, [Validators.required, Validators.minLength(6), Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/)]],
    gender: [null, Validators.required],
    phoneNumber: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern(/^[6-9][0-9]{9}/)]]
  });

  constructor(private fb: FormBuilder, private login: LoginService, private route: Router, private snackbar: MatSnackBar) { }
  formdata = new FormData;

  get username() { return this.addressForm.get("username") }
  get email() { return this.addressForm.get("email") }
  get password() { return this.addressForm.get("password"); }
  get gender() { return this.addressForm.get("gender") }
  get phoneNumber() { return this.addressForm.get("phoneNumber"); }


  imgupload(event: any) {
    let file: any = event.target.files[0];
    console.log(file);
    this.formdata.append("file", file);
    this.snackbar.open("Profile picture updated Successfully!", "Close", { duration: 3000 });
  }



  onSubmit(): void {
    this.formdata.append("user", JSON.stringify(this.addressForm.value))
    this.login.storeData(this.formdata).subscribe({
      next: () => {
        console.log(this.formdata);
        this.snackbar.open("Registered Successfully!", "Close", { duration: 3000 });
        this.route.navigateByUrl('/login');
      },
      error: (err) => {
        if (err.status === 500) {
          this.snackbar.open("This email is already taken! Try using valid email", "Close", { duration: 3000 });
        } else {
          this.snackbar.open("Internal server error!", "Close", { duration: 3000 });
        }
      }
    });
  }
}
