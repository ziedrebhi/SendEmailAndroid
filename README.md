SendEmailAndroid
================

[Tutoriel] :Envoyer un email depuis une application Android 

String to = "email de destinataire";
  String subject = "objet d'email";
  String message = "message";
  String toCc = "email de destinataire en CC";
  String toCci = "email de destinataire en CCi";
  Intent email = new Intent(Intent.ACTION_SEND);
  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
  //email.putExtra(Intent.EXTRA_CC, new String[]{ toCc});
  //email.putExtra(Intent.EXTRA_BCC, new String[]{toCci});
  //email.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/file.pdf");
  email.putExtra(Intent.EXTRA_SUBJECT, subject);
  email.putExtra(Intent.EXTRA_TEXT, message);
   
  email.setType("message/rfc822");
    
  startActivity(Intent.createChooser(email, "Choisissez un client
                de messagerie:"));
