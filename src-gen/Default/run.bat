echo SELECT 'CREATE DATABASE onlineticketing_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'onlineticketing_product_default') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/onlineticketing_product_default"

java -cp onlineticketing.product.default --module-path onlineticketing.product.default -m onlineticketing.product.default