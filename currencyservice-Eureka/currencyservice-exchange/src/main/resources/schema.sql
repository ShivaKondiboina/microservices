
    CREATE TABLE IF NOT EXISTS currency_exchange(
	id BIGINT PRIMARY KEY,
	conversion_Rate DOUBLE NOT NULL,
	from_currency VARCHAR(255) NOT NULL,
	to_currency VARCHAR(255) NOT NULL
);