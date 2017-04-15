# JavaEE-Blog

Controllers – hold the presentation (UI) logic – process user request (GET / POST / other), prepare data for the view and render the view (or redirect to another URL). Example: prepare and show the home page.

Services – hold the business logic. Often just call some repository method. Example: create new post / show a post for deleting / delete post. Services may have several implementations: DB based or stub based.

Repositories – implement the database CRUD operations (create / read / edit / delete) in the database for certain entity class (model). Examples: find post by id / delete post by id. Often provided by the framework (not written by hand).

Models (entity classes) – holds the data about the application data. Examples: user, post, tag, …