export class User{
      email?: String;
      username?: String;
      password?: String;
      gender?: String;
      phoneNumber?: String;
      imageName?:String;
      image?:any;

      constructor()
      {
        this.email="",
        this.username="",
        this.password="",
        this.gender="",
        this.phoneNumber="",
        this.imageName="",
        this.image=""
      }
}