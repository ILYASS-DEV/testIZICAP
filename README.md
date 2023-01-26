# testIZICAP


1.clone the code.<br />
2.set your chatgpt.api-key in "ChatGPTService class".<br />
3.run it, and then you can chat with chatgpt by this api.<br />

*request
>curl --location --request GET '127.0.0.1:8080/send?message=What is gluten sensitivity?',


*response

>{
>  "code": 200,
> "message": "success",
>  "data": "\n\nGluten sensitivity, also known as non-celiac gluten sensitivity (NCGS), is a condition characterized by symptoms that improve on a gluten-free diet, but do not meet the criteria for celiac disease, an autoimmune disorder triggered by gluten. Symptoms of gluten sensitivity can include abdominal pain, bloating, diarrhea, constipation, headaches, fatigue, and "brain fog." The exact cause of gluten sensitivity is not known, and there is currently no diagnostic test for the condition. A gluten-free diet is the most effective treatment for gluten sensitivity."
>}
