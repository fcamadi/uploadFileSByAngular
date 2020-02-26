import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {FileUploader} from 'ng2-file-upload';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
 
  title = 'Nymiz Upload File Service';
  serviceUrl: string = 'http://localhost:8080/api/v1/files';
  //serviceUrl: string = 'http://localhost:8080/api/v1/anonymization/anonymizefile';

  @ViewChild('fileInput') fileInput: ElementRef;

  uploader: FileUploader;
  isDropOver: boolean;
 
  ngOnInit(): void {
    const headers = [{name: 'Accept', value: 'multipart/form-data'}   
                    ];
                    // {name: 'Accept', value: 'application/json'}
                    //  {name: 'content-type', value: 'multipart/form-data'}
                    // {name: 'access-control-allow-credentials', value: 'false'}
                    // {name: 'access-control-allow-origin', value: '*'}
    //this.uploader = new FileUploader({url: this.serviceUrl, autoUpload: true, headers: headers});
    
    
    this.uploader = new FileUploader({
      url: this.serviceUrl,
      autoUpload: true,
      method: 'post',
      itemAlias: 'file',
      allowedFileType: ['doc', 'docx', 'pdf', 'PDF'],
      headers: headers
      });
      
      
      this.uploader.onCompleteAll = () => alert('File uploaded');
  }

  
  fileOverAnother(e: any): void {
    this.isDropOver = e;
  }
 
  fileClicked() {
    this.fileInput.nativeElement.click();
  }
}
