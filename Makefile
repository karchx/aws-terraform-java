.PHONY: re-compile

re-compile: down
	@docker compose build app mvn

down:
	@docker compose down app mvn
